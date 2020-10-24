package me.github.wert.bitcosmetics.commands;

import me.github.wert.bitcosmetics.gui.MenuGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class test implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        MenuGUI m = new MenuGUI();
        m.openInv((Player) sender);
        return false;
    }


}
