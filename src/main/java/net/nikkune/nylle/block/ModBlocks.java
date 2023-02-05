package net.nikkune.nylle.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nikkune.nylle.Nylle;
import net.nikkune.nylle.api.tiers.BaseTiers;
import net.nikkune.nylle.block.custom.SmelterBlock;
import net.nikkune.nylle.item.ModItems;
import net.nikkune.nylle.item.custom.BlockTieredItem;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nylle.MOD_ID);

    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_IRIDIUM_ORE = registerBlock("deepslate_iridium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_OSMIUM_ORE = registerBlock("deepslate_osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_TUNGSTEN_ORE = registerBlock("deepslate_tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.5f).explosionResistance(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).explosionResistance(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> PLATINUM_ORE = registerBlock("platinum_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> IRIDIUM_ORE = registerBlock("iridium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> OSMIUM_ORE = registerBlock("osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).explosionResistance(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).explosionResistance(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).explosionResistance(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).explosionResistance(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).explosionResistance(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PLATINUM_BLOCK = registerBlock("platinum_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).explosionResistance(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> IRIDIUM_BLOCK = registerBlock("iridium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).explosionResistance(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSMIUM_BLOCK = registerBlock("osmium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).explosionResistance(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUNGSTEN_BLOCK = registerBlock("tungsten_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).explosionResistance(8f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> TIN_SMELTER = registerSmelter(BaseTiers.TIN);
    public static final RegistryObject<Block> LEAD_SMELTER = registerSmelter(BaseTiers.LEAD);
    public static final RegistryObject<Block> SILVER_SMELTER = registerSmelter(BaseTiers.SILVER);
    public static final RegistryObject<Block> PLATINUM_SMELTER = registerSmelter(BaseTiers.PLATINUM);
    public static final RegistryObject<Block> IRIDIUM_SMELTER = registerSmelter(BaseTiers.IRIDIUM);
    public static final RegistryObject<Block> OSMIUM_SMELTER = registerSmelter(BaseTiers.OSMIUM);
    public static final RegistryObject<Block> TUNGSTEN_SMELTER = registerSmelter(BaseTiers.TUNGSTEN);

    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> registerItemduct(BaseTiers tier) {
        return (RegistryObject<T>) registerTierBlock(tier, "itemduct", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(3f).explosionResistance(3f).requiresCorrectToolForDrops()));
    }

    @SuppressWarnings("unchecked")
    private static <T extends Block> RegistryObject<T> registerSmelter(BaseTiers tier) {
        return (RegistryObject<T>) registerTierBlock(tier, "smelter", () -> new SmelterBlock(BlockBehaviour.Properties.of(Material.METAL).strength(3f).explosionResistance(3f).requiresCorrectToolForDrops()));
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerTierBlock(BaseTiers tier, String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(tier.getLower() + "_" + name, block);
        registerTieredBlockItem(tier, name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerTieredBlockItem(BaseTiers tier, String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(tier.getLower() + "_" + name, () -> new BlockTieredItem(block.get(), new Item.Properties(), tier));
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
