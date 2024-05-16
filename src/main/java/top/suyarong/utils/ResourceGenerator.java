package top.suyarong.utils;

import net.minecraft.util.ResourceLocation;
import top.suyarong.AvaritiaItem;
import top.suyarong.items.AvaritiaBasicItem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ResourceGenerator {

    public static void generateItemModel(List<AvaritiaBasicItem> avaritiaBasicItems) {
        generateResourceFolder();
        avaritiaBasicItems.forEach(ResourceGenerator::generateNewAvaritiaItem);
    }

    private static void generateResourceFolder() {
        final File langFile = new File("resources/avaritiaitem/lang");
        final File itemFile = new File("resources/avaritiaitem/textures/items");
        if (langFile.exists() && itemFile.exists()) return;

        langFile.mkdirs();
        itemFile.mkdirs();
    }

    private static void generateNewAvaritiaItem(AvaritiaBasicItem avaritiaBasicItem) {

        final ResourceLocation registryName = avaritiaBasicItem.getRegistryName();
        final String type = avaritiaBasicItem.getType();
        assert registryName != null;
        final String nameString = registryName.getPath();

        final String modelJson = BasicItemModel.jsonGenerator(type, nameString);

        final File file = new File("resources/avaritiaitem/cc_blockstates/" + nameString + ".json");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.createNewFile()) {
                AvaritiaItem.log.warn(String.format("[AvaritiaItem] Item %s model file create failed", nameString));
            }
            try (FileWriter fileWriter = new FileWriter(file);
                 BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(modelJson);
            }
            AvaritiaItem.log.info(String.format("[AvaritiaItem] Item %s model file create success", nameString));
        } catch (IOException e) {
            AvaritiaItem.log.warn(String.format("[AvaritiaItem] Item %s model file create failed", nameString));
        }

    }

}
