package org.unitedlands.utils;

import org.unitedlands.config.UnitedLibConfig;

import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver.Builder;

public class UnitedMiniMessage {

    private MiniMessage miniMessage;

    public MiniMessage get() {
        return miniMessage;
    }

    UnitedMiniMessage() { 
        loadPlaceholders(); 
    }

    public void loadPlaceholders() {

        Builder resolverBuilder = TagResolver.builder();
        for (var tagPlaceholder : UnitedLibConfig.get().minimessagePlaceholders().values()) {
            resolverBuilder = resolverBuilder.resolver(
                Placeholder.styling(
                    tagPlaceholder.tag(), 
                    TextColor.fromHexString(tagPlaceholder.color())
                )
            );
        }
        miniMessage = MiniMessage.builder()
            .tags(TagResolver.builder()
                .resolver(TagResolver.standard()) 
                .resolver(resolverBuilder.build())
                .build())
            .build();
    }


}
