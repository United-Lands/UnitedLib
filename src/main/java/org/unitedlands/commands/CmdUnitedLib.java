package org.unitedlands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.unitedlands.config.UnitedLibConfig;
import org.unitedlands.utils.United;

public class CmdUnitedLib implements CommandExecutor {

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            @NotNull Command cmd,
            @NotNull String alias,
            @NotNull String @NotNull [] args) {

        if (args.length == 0)
            return false;

        if (args[0].equalsIgnoreCase("reload")) {

            UnitedLibConfig.get().reload();
            United.miniMessage().loadPlaceholders();

            United.messenger().send(sender, United.miniMessage().get().deserialize("<success>Plugin reloaded.</success>"));
            
            return true;
        }

        return false;
    }

}
