package chronosacaria.mcdw.enchants.enchantments;

import chronosacaria.mcdw.Mcdw;
import chronosacaria.mcdw.api.util.McdwEnchantmentHelper;
import chronosacaria.mcdw.bases.McdwCustomWeaponBase;
import chronosacaria.mcdw.enchants.EnchantsRegistry;
import chronosacaria.mcdw.enchants.types.AOEEnchantment;
import chronosacaria.mcdw.enchants.types.DamageBoostEnchantment;
import chronosacaria.mcdw.enums.EnchantStatsID;
import chronosacaria.mcdw.enums.EnchantmentsID;
import chronosacaria.mcdw.enums.SettingsID;
import chronosacaria.mcdw.statuseffects.StatusEffectsRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;

public class DynamoEnchantment extends DamageBoostEnchantment {
    public DynamoEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
        if (Mcdw.CONFIG.mcdwEnchantmentsConfig.enableEnchantments.get(EnchantmentsID.DYNAMO)) {
            Registry.register(Registry.ENCHANTMENT, Mcdw.ID("dynamo"), this);
        }
    }

    @Override
    public int getMaxLevel() { return 3; }

    @Override
    protected boolean canAccept (Enchantment other) {
        return Mcdw.CONFIG.mcdwEnchantmentSettingsConfig.enableEnchantmentSettings.get(SettingsID.ENABLE_OP_ENCHANTMENT_MIXING)
                || !(other instanceof AOEEnchantment || other instanceof DamageBoostEnchantment);
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return Mcdw.CONFIG.mcdwEnchantmentsConfig.enableEnchantments.get(EnchantmentsID.DYNAMO)
                && Mcdw.CONFIG.mcdwEnchantmentsConfig.enableRandomSelection.get(EnchantmentsID.DYNAMO);
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return Mcdw.CONFIG.mcdwEnchantmentsConfig.enableEnchantments.get(EnchantmentsID.DYNAMO)
                && Mcdw.CONFIG.mcdwEnchantmentsConfig.enableVillageTrading.get(EnchantmentsID.DYNAMO);
    }

    public static void handleAddDynamoEnchantment(PlayerEntity playerEntity) {
        ItemStack mainHandStack = playerEntity.getMainHandStack();
        if (McdwEnchantmentHelper.hasEnchantment(mainHandStack, EnchantsRegistry.DYNAMO)) {
            StatusEffectInstance dynamoInstance = playerEntity.getStatusEffect(StatusEffectsRegistry.DYNAMO);
            int i = 1;
            if (dynamoInstance != null) {
                i += dynamoInstance.getAmplifier();
            } else {
                --i;
            }
            i = MathHelper.clamp(i, 0, Mcdw.CONFIG.mcdwEnchantmentSettingsConfig.dynamoStackCap.get(EnchantStatsID.DYNAMO_STACK_CAP));
            StatusEffectInstance dynamoUpdateInstance = new StatusEffectInstance(StatusEffectsRegistry.DYNAMO, 120000, i, false, false, true);
            playerEntity.addStatusEffect(dynamoUpdateInstance);
        }
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem || stack.getItem() instanceof AxeItem || stack.getItem() instanceof McdwCustomWeaponBase
                || stack.getItem() instanceof BowItem || stack.getItem() instanceof CrossbowItem;
    }
}
