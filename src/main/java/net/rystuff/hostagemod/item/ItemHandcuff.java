package net.rystuff.hostagemod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemHandcuff extends Item
{
    public ItemHandcuff()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Handcuffs");
        setTextureName("hostagemod:handcuff");
        setMaxStackSize(1);
        setHasSubtypes(true);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.stackTagCompound != null) {
            String owner = itemStack.stackTagCompound.getString("owner");
            int code = itemStack.stackTagCompound.getInteger("code");
            list.add("owner: " + owner);
            if (owner.equals(player.getDisplayName())) {
                list.add(EnumChatFormatting.GREEN + "code: " + code);
            } else {
                list.add(EnumChatFormatting.RED + "code: "
                         + EnumChatFormatting.OBFUSCATED + code);
            }
        }
    }
}
