package chronosacaria.mcdw.weapons;

import chronosacaria.mcdw.bases.McdwDagger;
import net.minecraft.item.ToolMaterials;

public class Daggers {
    public static McdwDagger DAGGER_DAGGER;
    public static McdwDagger DAGGER_FANGS_OF_FROST;
    public static McdwDagger DAGGER_MOON;
    //public static McdwDagger DAGGER_CHILL_GALE_KNIFE;
    //public static McdwDagger DAGGER_RESOLUTE_TEMPEST_KNIFE;
    public static McdwDagger DAGGER_SHEAR_DAGGER;

    public static void init() {
        DAGGER_DAGGER = new McdwDagger(ToolMaterials.IRON, 1, -1.3F, "dagger_dagger");
        DAGGER_FANGS_OF_FROST = new McdwDagger(ToolMaterials.IRON, 1, -1.0F, "dagger_fangs_of_frost");
        DAGGER_MOON = new McdwDagger(ToolMaterials.IRON, 1, -1.0F, "dagger_moon");
        //DAGGER_CHILL_GALE_KNIFE = new McdwDagger(ToolMaterials.IRON, 4, -1.3F, "dagger_chill_gale_knife");
        //DAGGER_RESOLUTE_TEMPEST_KNIFE = new McdwDagger(ToolMaterials.IRON, 4, -1.3F, "dagger_resolute_tempest_knife");
        DAGGER_SHEAR_DAGGER = new McdwDagger(ToolMaterials.IRON, 1, -1.3F, "dagger_shear_dagger");
    }
}


