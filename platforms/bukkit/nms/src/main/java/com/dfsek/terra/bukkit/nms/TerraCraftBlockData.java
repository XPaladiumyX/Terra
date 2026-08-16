package com.dfsek.terra.bukkit.nms;

import net.minecraft.world.level.block.state.BlockState;
import org.bukkit.craftbukkit.block.data.CraftBlockData;


/**
 * Direct instantiation of {@link CraftBlockData} that bypasses the non-thread-safe
 * {@code INSTANCE_CREATOR} cache used by {@code CraftBlockData.createData(BlockState)}.
 */
public class TerraCraftBlockData extends CraftBlockData {
    public TerraCraftBlockData(BlockState state) {
        super(state);
    }
}
