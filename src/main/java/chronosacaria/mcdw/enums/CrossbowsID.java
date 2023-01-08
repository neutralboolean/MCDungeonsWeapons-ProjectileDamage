package chronosacaria.mcdw.enums;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.bases.McdwCrossbow;
import chronosacaria.mcdw.configs.McdwNewStatsConfig;
import chronosacaria.mcdw.items.ItemsInit;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;

import java.util.EnumMap;
import java.util.HashMap;

import static chronosacaria.mcdw.Mcdw.CONFIG;

public enum CrossbowsID implements IRangedWeaponID {
    CROSSBOW_AUTO_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_AZURE_SEEKER(ToolMaterials.IRON, 28, 8.4f, "minecraft:iron_ingot"),
    CROSSBOW_BABY_CROSSBOW(ToolMaterials.IRON, 23, 7.2f, "minecraft:iron_ingot"),
    CROSSBOW_BURST_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_BUTTERFLY_CROSSBOW(ToolMaterials.IRON, 28, 8.9f, "minecraft:iron_ingot"),
    CROSSBOW_COG_CROSSBOW(ToolMaterials.IRON, 28, 8.4f, "minecraft:iron_ingot"),
    CROSSBOW_CORRUPTED_CROSSBOW(ToolMaterials.NETHERITE, 22, 14.0f, "minecraft:netherite_scrap"),
    CROSSBOW_DOOM_CROSSBOW(ToolMaterials.NETHERITE, 26, 8.0f, "minecraft:netherite_scrap"),
    CROSSBOW_DUAL_CROSSBOW(ToolMaterials.IRON, 24, 7.0f, "minecraft:iron_ingot"),
    CROSSBOW_EXPLODING_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_FERAL_SOUL_CROSSBOW(ToolMaterials.IRON, 28, 9.2f, "minecraft:iron_ingot"),
    CROSSBOW_FIREBOLT_THROWER(ToolMaterials.IRON, 28, 7.9f, "minecraft:iron_ingot"),
    CROSSBOW_HARPOON_CROSSBOW(ToolMaterials.IRON, 28, 11.0f, "minecraft:iron_ingot"),
    CROSSBOW_HARP_CROSSBOW(ToolMaterials.IRON, 28, 8.6f, "minecraft:iron_ingot"),
    CROSSBOW_HEAVY_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_IMPLODING_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_LIGHTNING_HARP_CROSSBOW(ToolMaterials.DIAMOND, 28, 14.2f, "minecraft:diamond"),
    CROSSBOW_NAUTICAL_CROSSBOW(ToolMaterials.DIAMOND, 24, 14.0f, "minecraft:diamond"),
    CROSSBOW_PRIDE_OF_THE_PIGLINS(ToolMaterials.NETHERITE, 20, 13.0f, "minecraft:netherite_scrap"),
    CROSSBOW_RAPID_CROSSBOW(ToolMaterials.IRON, 20, 8.2f, "minecraft:iron_ingot"),
    CROSSBOW_SCATTER_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_SHADOW_CROSSBOW(ToolMaterials.DIAMOND, 25, 12.0f, "minecraft:diamond"),
    CROSSBOW_SLAYER_CROSSBOW(ToolMaterials.DIAMOND, 26, 8.8f, "minecraft:diamond"),
    CROSSBOW_SOUL_CROSSBOW(ToolMaterials.IRON, 28, 8.0f, "minecraft:iron_ingot"),
    CROSSBOW_SOUL_HUNTER_CROSSBOW(ToolMaterials.DIAMOND, 28, 11.0f, "minecraft:diamond"),
    CROSSBOW_SPELLBOUND_CROSSBOW(ToolMaterials.IRON, 28, 8.9f, "minecraft:iron_ingot"),
    CROSSBOW_THE_SLICER(ToolMaterials.IRON, 28, 10.2f, "minecraft:iron_ingot"),
    CROSSBOW_VEILED_CROSSBOW(ToolMaterials.DIAMOND, 22, 14.5f, "minecraft:diamond"),
    CROSSBOW_VOIDCALLER_CROSSBOW(ToolMaterials.DIAMOND, 26, 12.5f, "minecraft:diamond");

    public final ToolMaterial material;
    public final int drawSpeed;
    public final float range;
    private final String[] repairIngredient;

    CrossbowsID(ToolMaterial material, int drawSpeed, float range, String... repairIngredient) {
        this.material = material;
        this.drawSpeed = drawSpeed;
        this.range = range;
        this.repairIngredient = repairIngredient;
    }

    public static HashMap<CrossbowsID, Boolean> getEnabledItems(){
        return Mcdw.CONFIG.mcdwEnableItemsConfig.CROSSBOWS_ENABLED;
    }

    public static EnumMap<CrossbowsID, McdwCrossbow> getItemsEnum() {
        return ItemsInit.CROSSBOW_ITEMS;
    }

    public static HashMap<CrossbowsID, Integer> getSpawnRates() {
        return Mcdw.CONFIG.mcdwNewlootConfig.CROSSBOW_SPAWN_RATES;
    }

    public static HashMap<CrossbowsID, RangedStats> getWeaponStats() {
        return CONFIG.mcdwNewStatsConfig.crossbowStats;
    }

    @Override
    public Boolean isEnabled(){
        return getEnabledItems().get(this);
    }

    @Override
    public McdwCrossbow getItem() {
        return getItemsEnum().get(this);
    }

    @Override
    public Integer getItemSpawnRate() {
        return getSpawnRates().get(this);
    }

    @Override
    public HashMap<CrossbowsID, RangedStats> getWeaponStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.crossbowStats;
    }

    @Override
    public RangedStats getWeaponItemStats() {
        return getWeaponStats().get(this);
    }

    @Override
    public RangedStats getWeaponItemStats(McdwNewStatsConfig mcdwNewStatsConfig) {
        return mcdwNewStatsConfig.crossbowStats.get(this);
    }

    @Override
    public ToolMaterial getMaterial() {
        return material;
    }

    @Override
    public double getProjectileDamage() {
        return projectileDamage;
    }

    @Override
    public int getDrawSpeed() {
        return drawSpeed;
    }

    @Override
    public float getRange() {
        return range;
    }

    @Override
    public String[] getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public McdwCrossbow makeWeapon() {
        McdwCrossbow mcdwCrossbow = new McdwCrossbow(ItemsInit.stringToMaterial(this.getWeaponItemStats().material),
                this.getWeaponItemStats().drawSpeed, this.getWeaponItemStats().range, this.getWeaponItemStats().repairIngredient);

        getItemsEnum().put(this, mcdwCrossbow);
        return mcdwCrossbow;
    }
}