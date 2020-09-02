package dev.toka.pl;

import cn.nukkit.event.Listener;
import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import dev.toka.pl.command.BaseCommand;
import dev.toka.pl.tokaControl.bstats.MetricsLite;

public class Main extends PluginBase implements Listener {

    private static Main instance;

    @Override
    public void onLoad() {
        this.getLogger().info("[prj_Toka]正在載入 ");
    }

    @Override
    public void onEnable() {
        this.getLogger().info("[prj_Toka]載入完成");
        instance = this;
        
        MetricsLite metricsLite = new MetricsLite(this);
        if (metricsLite.isEnabled()) {
            getLogger().info("[bStats]已允許傳送資料");
        }

        this.registerEvents();
        this.loadWorld();
        this.registerCommandMap();
    }

    @Override
    public void onDisable() {
        this.getLogger().info("[prj_Toka]正在關閉");
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    private void loadWorld() {
        this.getServer().loadLevel("HePingZhiDi");
        if (!this.getServer().loadLevel("ZiYuan")) {
            this.getServer().generateLevel("ZiYuan", 20200713, Generator.getGenerator(1));
        }
    }

    private void registerCommandMap() {
        this.getServer().getCommandMap().register("cmd", new BaseCommand());
    }

    public static Main getInstance() {
        return instance;
    }
}
