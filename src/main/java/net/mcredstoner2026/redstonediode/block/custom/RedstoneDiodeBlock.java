package net.mcredstoner2026.redstonediode.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class RedstoneDiodeBlock extends Block {
    private static final VoxelShape SHAPE = VoxelShapes.union(
            // Base
            Block.createCuboidShape(5, 0, 5, 11, 2, 11),

            // Middle
            Block.createCuboidShape(6, 2, 6, 10, 4, 10),

            // Stem
            Block.createCuboidShape(7, 4, 7, 9, 14, 9),

            // Top
            Block.createCuboidShape(6, 14, 6, 10, 16, 10)
    );

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
        return world.getReceivedRedstonePower(pos.down());
    }

    private static void updatePower(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);

        int power = getInputPower(world, pos);
        boolean powered = power > 0;

        if (state.get(POWER) != power || state.get(POWERED) != powered) {
            world.setBlockState(
                    pos,
                    state
                            .with(POWER, power)
                            .with(POWERED, powered)
            );
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
            BlockPos sourcePos,
            boolean notify
    ) {
        updatePower(world, pos);

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
    public boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    public int getStrongRedstonePower(
            BlockState state,
            BlockView world,
            BlockPos pos,
            Direction direction
    ) {
        if (direction == Direction.UP) {
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
        if (direction == Direction.UP) {
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
}
