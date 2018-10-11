package SpringBoot_MybatisPlus.config;

import SpringBoot_MybatisPlus.realms.AuthRealm;
import SpringBoot_MybatisPlus.utils.Constants;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

        @Bean
        public ShiroFilterFactoryBean shiroFilter(@Autowired DefaultWebSecurityManager securityManager) {
            ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
            shiroFilter.setSecurityManager(securityManager);

            shiroFilter.setLoginUrl("/");
            shiroFilter.setUnauthorizedUrl("/unauthorized");

            LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
            filterChainDefinitionMap.put("/","anon");
            filterChainDefinitionMap.put("/login_form","anon");
            filterChainDefinitionMap.put("/register","anon");
            filterChainDefinitionMap.put("/register_form","anon");
            filterChainDefinitionMap.put("/checkLoginName","anon");
            filterChainDefinitionMap.put("/logout123","logout");
            filterChainDefinitionMap.put("/aaa","authc,roles[ccc]");
            filterChainDefinitionMap.put("/static/**","anon");
            filterChainDefinitionMap.put("/**","authc");

            shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
            return shiroFilter;
        }

        @Bean
        public DefaultWebSecurityManager securityManager(@Autowired AuthRealm authRealm) {
            DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
            CredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
            ((HashedCredentialsMatcher) credentialsMatcher).setHashAlgorithmName(Constants.HASH_ALGORITHM);
            ((HashedCredentialsMatcher) credentialsMatcher).setHashIterations(Constants.HASH_INTERATIONS);
            authRealm.setCredentialsMatcher(credentialsMatcher);
            securityManager.setRealm(authRealm);
            securityManager.setRememberMeManager(rememberMeManager());
            return securityManager;
        }

        @Bean
        public SimpleCookie rememberMeCookie() {
            SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
            simpleCookie.setMaxAge(604800);
            return simpleCookie;
        }

        @Bean
        public CookieRememberMeManager rememberMeManager() {
            CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager() ;
            cookieRememberMeManager.setCookie(rememberMeCookie());
            cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
            return cookieRememberMeManager;
        }

        @Bean
        public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
            return new LifecycleBeanPostProcessor();
        }

        @Bean
        public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
            DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
            creator.setProxyTargetClass(true);
            return creator;
        }

        @Bean
        public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Autowired DefaultWebSecurityManager defaultWebSecurityManager) {
            AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
            advisor.setSecurityManager(defaultWebSecurityManager);
            return advisor;
        }

        @Bean
        public ShiroDialect dialect() {
            return new ShiroDialect();
        }
}
