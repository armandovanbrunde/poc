package com.vattenfall.mock;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "route")
public class DynamicConfig {
    private String mockPassword;
    private String mockUser;

    public String getMockPassword() {
        return mockPassword;
    }

    public String getMockUser() {
        return mockUser;
    }

    public void setMockPassword(String mockPassword) {
        this.mockPassword = mockPassword;
    }

    public void setMockUser(String mockUser) {
        this.mockUser = mockUser;
    }


}
