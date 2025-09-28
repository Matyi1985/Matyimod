package net.matyi.matyimod.datagen.loot;

import java.util.function.BiConsumer;

import net.matyi.matyimod.matyimod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.data.loot.LootTableSubProvider;

/**
 * Generates archaeology loot tables (used by brushable blocks like suspicious_sand and suspicious_gravel).
 *
 * Add more calls to out.accept(...) to create additional tables under data/matyimod/loot_tables/archaeology/.
 */
public class ModArchaeologyLootTables implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceLocation, LootTable.Builder> out) {
        // Example table: always yields a single diamond when brushed
        out.accept(new ResourceLocation(matyimod.MOD_ID, "archaeology/example_diamond"),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.DIAMOND))
                )
        );

        // Example weighted table: 90% emerald, 10% diamond
        out.accept(new ResourceLocation(matyimod.MOD_ID, "archaeology/example_weighted"),
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(Items.EMERALD).setWeight(9))
                                .add(LootItem.lootTableItem(Items.DIAMOND).setWeight(1))
                )
        );
    }
}
