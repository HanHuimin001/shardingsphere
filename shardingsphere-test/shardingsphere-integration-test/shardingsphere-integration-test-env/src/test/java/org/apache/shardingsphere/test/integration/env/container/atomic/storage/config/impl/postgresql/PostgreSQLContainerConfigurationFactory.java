/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.integration.env.container.atomic.storage.config.impl.postgresql;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.test.integration.env.container.atomic.storage.config.StorageContainerConfiguration;

import java.util.Collections;
import java.util.Map;

/**
 * PostgreSQL container configuration factory.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PostgreSQLContainerConfigurationFactory {
    
    /**
     * Create new instance of postgresql container configuration.
     * 
     * @return created instance
     */
    public static StorageContainerConfiguration newInstance() {
        return new StorageContainerConfiguration(getCommands(), getContainerEnvironments(), getMountedResources());
    }
    
    private static String[] getCommands() {
        String[] result = new String[1];
        result[0] = "-c config_file=/etc/postgresql/postgresql.conf";
        return result;
    }
    
    private static Map<String, String> getContainerEnvironments() {
        return Collections.singletonMap("POSTGRES_PASSWORD", "Test@123");
    }
    
    private static Map<String, String> getMountedResources() {
        return Collections.singletonMap("/env/postgresql/postgresql.conf", "/etc/postgresql/postgresql.conf");
    }
}