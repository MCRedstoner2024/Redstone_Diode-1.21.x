package net.mcredstoner2026.redstonediode.block.custom;

import net.mcredstoner2026.redstonediode.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.tick.ScheduledTickView;

public class RedstoneDiodeBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.union(
            Block.createCuboidShape(5, 0, 5, 11, 2, 11),
            Block.createCuboidShape(6, 2, 6, 10, 4, 10),
            Block.createCuboidShape(7, 4, 7, 9, 14, 9),
            Block.createCuboidShape(6, 14, 6, 10, 16, 10)
    );

    private static final int DELAY = 2;

    public static final IntProperty POWER = Properties.POWER;
    public static final BooleanProperty POWERED = Properties.POWERED;

    public RedstoneDiodeBlock(Settings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState()
                .with(POWER, 0)
                .with(POWERED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWER, POWERED);
    }

    private static int getInputPower(World world, BlockPos pos) {
        return  world.getBlockState(pos.down()).isFullCube(world,pos.down()) ? world.getReceivedStrongRedstonePower(pos.down()) : 0;
    }

    private void updatePower(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        int power = getInputPower(world, pos);
        boolean powered = power > 0;
        if (state.get(POWER) != power || state.get(POWERED) != powered) {
            world.setBlockState(
                    pos,
                    state.with(POWER, power).with(POWERED, powered)
            );

            world.updateNeighborsAlways(pos.up(), this, null);
            world.updateNeighborsAlways(pos, this, null);
        }
    }

    @Override
    protected void onBlockAdded(
            BlockState state,
            World world,
            BlockPos pos,
            BlockState oldState,
            boolean notify
    ) {
        super.onBlockAdded(state, world, pos, oldState, notify);

        updatePower(world, pos);
    }

    @Override
    protected void neighborUpdate(
            BlockState state,
            World world,
            BlockPos pos,
            Block sourceBlock,
            WireOrientation sourcePos,
            boolean notify
    ) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, DELAY);
        }

        super.neighborUpdate(
                state,
                world,
                pos,
                sourceBlock,
                sourcePos,
                notify
        );
    }

    @Override
    public int getStrongRedstonePower(
            BlockState state,
            BlockView world,
            BlockPos pos,
            Direction direction
    ) {
        if (direction == Direction.DOWN) {
            return state.get(POWER);
        }

        return 0;
    }


    @Override
    public int getWeakRedstonePower(
            BlockState state,
            BlockView world,
            BlockPos pos,
            Direction direction
    ) {
        if (direction == Direction.DOWN) {
            return state.get(POWER);
        }

        return 0;
    }

    @Override
    protected VoxelShape getOutlineShape(
            BlockState state,
            BlockView world,
            BlockPos pos,
            ShapeContext context
    ) {
        return SHAPE;
    }

    @Override
    protected VoxelShape getCollisionShape(
            BlockState state,
            BlockView world,
            BlockPos pos,
            ShapeContext context
    ) {
        return SHAPE;
    }

    private static boolean hasSupport(WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isFullCube(world,pos.down()) && world.getBlockState(pos.down()).isOpaque();
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isFullCube(world,pos.down()) && world.getBlockState(pos.down()).isOpaque();
    }

    protected BlockState getStateForNeighborUpdate(
            BlockState state,
            WorldView world,
            ScheduledTickView tickView,
            BlockPos pos,
            Direction direction,
            BlockPos neighborPos,
            BlockState neighborState,
            Random random

    ) {
        if (direction == Direction.DOWN && !hasSupport(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }

        return super.getStateForNeighborUpdate(
                state,
                world,
                tickView,
                pos,
                direction,
                neighborPos,
                neighborState,
                random
        );
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(ModBlocks.REDSTONE_DIODE);
    }

    @Override
    protected void scheduledTick(
            BlockState state,
            ServerWorld world,
            BlockPos pos,
            Random random
    ) {
        updatePower(world, pos);
    }
}
