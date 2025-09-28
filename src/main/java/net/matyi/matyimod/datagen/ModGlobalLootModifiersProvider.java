package net.matyi.matyimod.datagen;

import net.matyi.matyimod.item.ModItems;
import net.matyi.matyimod.loot.AddItemModifier;
import net.matyi.matyimod.loot.AddSusSandItemModifier;
import net.matyi.matyimod.matyimod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, matyimod.MOD_ID);
    }

    @Override
    protected void start() {
        add("pine_cone_from_grass", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build()}, ModItems.PINE_CONE.get()));

        add("pine_cone_from_creeper", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("entities/creeper")).build() }, ModItems.PINE_CONE.get()));

        add("metal_detector_from_jungle_temples", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.30f).build()}, ModItems.METAL_DETECTOR.get()));

        // Adds item when using the archaeology table (brushing) for desert pyramids specifically.
        // Important: archaeology only yields a single stack; we must REPLACE the result instead of adding.
        add("metal_detector_from_suspicious_sand",
                new AddSusSandItemModifier(new LootItemCondition[] {
                        new LootTableIdCondition.Builder(new ResourceLocation("archaeology/desert_pyramid")).build()
                }, ModItems.METAL_DETECTOR.get(), 0.17f));

        // To target more archaeology tables, copy the block above and change the loot table id, e.g.:
        // add("metal_detector_from_trail_ruins_common",
        //     new AddSusSandItemModifier(new LootItemCondition[] {
        //             new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_common")).build()
        //     }, ModItems.METAL_DETECTOR.get(), 0.25f));
        // add("metal_detector_from_trail_ruins_rare",
        //     new AddSusSandItemModifier(new LootItemCondition[] {
        //             new LootTableIdCondition.Builder(new ResourceLocation("archaeology/trail_ruins_rare")).build()
        //     }, ModItems.METAL_DETECTOR.get(), 0.25f));
        // add("metal_detector_from_ocean_ruin_warm",
        //     new AddSusSandItemModifier(new LootItemCondition[] {
        //             new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_warm")).build()
        //     }, ModItems.METAL_DETECTOR.get(), 0.25f));
        // add("metal_detector_from_ocean_ruin_cold",
        //     new AddSusSandItemModifier(new LootItemCondition[] {
        //             new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build()
        //     }, ModItems.METAL_DETECTOR.get(), 0.25f));
        
    }
}
