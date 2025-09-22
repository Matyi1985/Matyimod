package net.matyi.matyimod.item.custom;

import net.matyi.matyimod.item.ModItems;
import net.matyi.matyimod.matyimod;
import net.matyi.matyimod.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier SAPPHIRE = TierSortingRegistry.registerTier(
            new ForgeTier(3, 1500, 8f, 3f, 13,
                    ModTags.Blocks.NEEDS_SAPPHIRE_TOOL, () -> Ingredient.of(ModItems.SAPPHIRE.get())),
            new ResourceLocation(matyimod.MOD_ID, "sapphire"), List.of(Tiers.IRON), List.of());
}
