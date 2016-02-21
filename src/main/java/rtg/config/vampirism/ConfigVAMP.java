package rtg.config.vampirism;

import java.io.File;

import org.apache.logging.log4j.Level;

import rtg.api.biome.vampirism.config.BiomeConfigVAMP;
import rtg.config.BiomeConfigManager;
import cpw.mods.fml.common.FMLLog;

import net.minecraftforge.common.config.Configuration;

public class ConfigVAMP
{
    
    public static Configuration config;
    
    public static void init(File configFile)
    {
    
        config = new Configuration(configFile);
        
        try
        {
            config.load();
            
            BiomeConfigManager.setBiomeConfigsFromUserConfigs(BiomeConfigVAMP.getBiomeConfigs(), config);
            
        } catch (Exception e)
        {
            FMLLog.log(Level.ERROR, e, "RTG has had a problem loading VAMP configuration.");
        } finally
        {
            if (config.hasChanged())
            {
                config.save();
            }
        }
    }
}
