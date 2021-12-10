package chronosacaria.mcdw.loottables;

import chronosacaria.mcdw.enums.*;
import chronosacaria.mcdw.items.ItemRegistry;
import chronosacaria.mcdw.items.ItemsInit;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

import java.util.ArrayList;

import static chronosacaria.mcdw.Mcdw.CONFIG;

public class McdwNewLoottables {

    public static final ArrayList<String> COMMON_LOOT_TABLES =
            new ArrayList<>(CONFIG.mcdwNewlootConfig.commonLootTables.get(SettingsID.COMMON_LOOT_TABLES));
    public static final ArrayList<String> UNCOMMON_LOOT_TABLES =
            new ArrayList<>(CONFIG.mcdwNewlootConfig.uncommonLootTables.get(SettingsID.UNCOMMON_LOOT_TABLES));
    public static final ArrayList<String> RARE_LOOT_TABLES =
            new ArrayList<>(CONFIG.mcdwNewlootConfig.rareLootTables.get(SettingsID.RARE_LOOT_TABLES));
    public static final ArrayList<String> EPIC_LOOT_TABLES =
            new ArrayList<>(CONFIG.mcdwNewlootConfig.epicLootTables.get(SettingsID.EPIC_LOOT_TABLES));

    private static boolean commonLootTables(String lootTable){
        for (String id : COMMON_LOOT_TABLES){
            if (id.equals(lootTable)){
                return true;
            }
        }
        return false;
    }

    private static boolean uncommonLootTables(String lootTable){
        for (String id : UNCOMMON_LOOT_TABLES){
            if (id.equals(lootTable)){
                return true;
            }
        }
        return false;
    }

    private static boolean rareLootTables(String lootTable){
        for (String id : RARE_LOOT_TABLES){
            if (id.equals(lootTable)){
                return true;
            }
        }
        return false;
    }

    private static boolean epicLootTables(String lootTable){
        for (String id : EPIC_LOOT_TABLES){
            if (id.equals(lootTable)){
                return true;
            }
        }
        return false;
    }


    public static void init() {
        LootTableLoadingCallback.EVENT.register(((resourceManager, lootManager, id, supplier, setter) -> {
            if ("minecraft:entities/bee".equals(id.toString())) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootNumberProvider.create(1, 1.0F))
                        .with(ItemEntry.builder(ItemRegistry.getItem("item_bee_stinger")));

                supplier.pool(poolBuilder);
            }

            if ("minecraft:entities/witch".equals(id.toString())) {
                LootPool poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ItemRegistry.getItem("spear_cackling_broom")).weight(1))
                        .withFunction(SetCountLootFunction.builder(UniformLootNumberProvider.create(0.0F,
                                1.0F)).build())
                        .withFunction(LootingEnchantLootFunction.builder(UniformLootNumberProvider.create(0.0F, 1.0F)).build())
                        .build();
                supplier.withPool(poolBuilder);
            }

            if (CONFIG.mcdwNewlootConfig.weaponsEnabledInLootTables.get(SettingsID.ENABLE_WEAPONS_IN_LOOTTABLES) &&
                    commonLootTables(COMMON_LOOT_TABLES.get(CONFIG.mcdwNewlootConfig.commonLootTables.size()))) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.axeSpawnRates.get(AxesID.AXE)))
                        .with(ItemEntry.builder(ItemsInit.axeItems.get(AxesID.AXE)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.daggerSpawnRates.get(DaggersID.DAGGER_DAGGER)))
                        .with(ItemEntry.builder(ItemsInit.daggerItems.get(DaggersID.DAGGER_DAGGER)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.gauntletSpawnRates.get(GauntletsID.GAUNTLET_GAUNTLET)))
                        .with(ItemEntry.builder(ItemsInit.gauntletItems.get(GauntletsID.GAUNTLET_GAUNTLET)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.glaiveSpawnRates.get(GlaivesID.SPEAR_GLAIVE)))
                        .with(ItemEntry.builder(ItemsInit.glaiveItems.get(GlaivesID.SPEAR_GLAIVE)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.spearSpawnRates.get(SpearsID.SPEAR_SPEAR)))
                        .with(ItemEntry.builder(ItemsInit.spearItems.get(SpearsID.SPEAR_SPEAR)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.sickleSpawnRates.get(SicklesID.SICKLE_SICKLE)))
                        .with(ItemEntry.builder(ItemsInit.sickleItems.get(SicklesID.SICKLE_SICKLE)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.staffSpawnRates.get(StavesID.STAFF_BATTLESTAFF)))
                        .with(ItemEntry.builder(ItemsInit.staffItems.get(StavesID.STAFF_BATTLESTAFF)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.axeSpawnRates.get(AxesID.AXE_ANCHOR)))
                        .with(ItemEntry.builder(ItemsInit.axeItems.get(AxesID.AXE_ANCHOR)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.hammerSpawnRates.get(HammersID.HAMMER_MACE)))
                        .with(ItemEntry.builder(ItemsInit.hammerItems.get(HammersID.HAMMER_MACE)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.hammerSpawnRates.get(HammersID.HAMMER_GREAT)))
                        .with(ItemEntry.builder(ItemsInit.hammerItems.get(HammersID.HAMMER_GREAT)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_IRON_SWORD_VAR)))
                        .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_IRON_SWORD_VAR)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_KATANA)))
                        .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_KATANA)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_RAPIER)))
                        .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_RAPIER)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_CUTLASS)))
                        .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_CUTLASS)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.longBowSpawnRates.get(LongBowsID.BOW_LONGBOW)))
                        .with(ItemEntry.builder(ItemsInit.longBowItems.get(LongBowsID.BOW_LONGBOW)))

                        .rolls(BinomialLootNumberProvider.create(1,
                                CONFIG.mcdwNewlootConfig.shortBowSpawnRates.get(ShortBowsID.BOW_SHORTBOW)))
                        .with(ItemEntry.builder(ItemsInit.shortBowItems.get(ShortBowsID.BOW_SHORTBOW)));

                supplier.pool(poolBuilder);
            }

           if (CONFIG.mcdwNewlootConfig.weaponsEnabledInLootTables.get(SettingsID.ENABLE_WEAPONS_IN_LOOTTABLES) &&
                   uncommonLootTables(UNCOMMON_LOOT_TABLES.get(CONFIG.mcdwNewlootConfig.uncommonLootTables.size())
                   )) {
               FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.whipSpawnRates.get(WhipsID.WHIP_WHIP)))
                       .with(ItemEntry.builder(ItemsInit.whipItems.get(WhipsID.WHIP_WHIP)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.whipSpawnRates.get(WhipsID.WHIP_VINE_WHIP)))
                       .with(ItemEntry.builder(ItemsInit.whipItems.get(WhipsID.WHIP_VINE_WHIP)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.axeSpawnRates.get(AxesID.AXE_FIREBRAND)))
                       .with(ItemEntry.builder(ItemsInit.axeItems.get(AxesID.AXE_FIREBRAND)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.hammerSpawnRates.get(HammersID.HAMMER_BONECLUB)))
                       .with(ItemEntry.builder(ItemsInit.hammerItems.get(HammersID.HAMMER_BONECLUB)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.hammerSpawnRates.get(HammersID.HAMMER_BONE_CUDGEL)))
                       .with(ItemEntry.builder(ItemsInit.hammerItems.get(HammersID.HAMMER_BONE_CUDGEL)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.scytheSpawnRates.get(ScythesID.SICKLE_SKULL_SCYTHE)))
                       .with(ItemEntry.builder(ItemsInit.scytheItems.get(ScythesID.SICKLE_SKULL_SCYTHE)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.sickleSpawnRates.get(SicklesID.SICKLE_NIGHTMARES_BITE)))
                       .with(ItemEntry.builder(ItemsInit.sickleItems.get(SicklesID.SICKLE_NIGHTMARES_BITE)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.scytheSpawnRates.get(ScythesID.SICKLE_SKULL_SCYTHE)))
                       .with(ItemEntry.builder(ItemsInit.scytheItems.get(ScythesID.SICKLE_SKULL_SCYTHE)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_BROKEN_SAWBLADE)))
                       .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_BROKEN_SAWBLADE)))
//
                       .rolls(BinomialLootNumberProvider.create(1,
                               CONFIG.mcdwNewlootConfig.swordSpawnRates.get(SwordsID.SWORD_MECHANIZED_SAWBLADE)))
                       .with(ItemEntry.builder(ItemsInit.swordItems.get(SwordsID.SWORD_MECHANIZED_SAWBLADE)));
//
               supplier.pool(poolBuilder);
           }

            //if (CONFIG.mcdwNewlootConfig.weaponsEnabledInLootTables.get(SettingsID.ENABLE_WEAPONS_IN_LOOTTABLES) &&
            //        rareLootTables(RARE_LOOT_TABLES.get(CONFIG.mcdwNewlootConfig.rareLootTables.size()))) {
            //    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            //            .rolls(BinomialLootNumberProvider.create(1, 1.00F))
            //            .with(ItemEntry.builder(ItemsInit.axeItems.get(AxesID.AXE)));
            //    supplier.pool(poolBuilder);
            //}

            //if (CONFIG.mcdwNewlootConfig.weaponsEnabledInLootTables.get(SettingsID.ENABLE_WEAPONS_IN_LOOTTABLES) &&
            //        epicLootTables(COMMON_LOOT_TABLES.get(CONFIG.mcdwNewlootConfig.epicLootTables.size()))) {
            //    FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
            //            .rolls(BinomialLootNumberProvider.create(1, 1.00F))
            //            .with(ItemEntry.builder(ItemsInit.axeItems.get(AxesID.AXE)));
            //    supplier.pool(poolBuilder);
            //}
        }));

    }
}