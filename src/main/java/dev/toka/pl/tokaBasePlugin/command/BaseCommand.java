package dev.toka.pl.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;

public class BaseCommand extends Command {

    public BaseCommand() {
        super("cmd", "指令描述");
        //this.commandParameters.clear();
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        return false;
    }
}
