package com.mockmate.service.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AiProviderFactory {

    private final Map<String, AiProvider> providers;
    
    @Value("${mockmate.ai.active-provider}")
    private String activeProviderName;

    public AiProviderFactory(Map<String, AiProvider> providers) {
        this.providers = providers;
    }

    public AiProvider getActiveProvider() {
        AiProvider provider = providers.get(activeProviderName);
        if (provider == null) {
            throw new IllegalArgumentException("Unsupported AI Provider: " + activeProviderName);
        }
        return provider;
    }
}
