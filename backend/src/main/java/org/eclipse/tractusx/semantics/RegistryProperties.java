/********************************************************************************
 * Copyright (c) 2021-2022 Robert Bosch Manufacturing Solutions GmbH
 * Copyright (c) 2021-2022 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ********************************************************************************/

package org.eclipse.tractusx.semantics;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Validated
@ConfigurationProperties(prefix = "registry")
public class RegistryProperties {

    private final Idm idm = new Idm();

    /**
     * Properties for Identity Management system
     */
    @Data
    @NotNull
    public static class Idm {
        /**
         * The public client id used for the redirect urls.
         */
        @NotEmpty(message = "public client id must not be empty")
        private String publicClientId;

        /**
         * The tenant id claim name in the jwt token.
         */
        @NotEmpty(message = "tenantId claimName must not be empty")
        private String tenantIdClaimName;

        /**
         * The owning tenant id to which this AAS Registry belongs to.
         */
        @NotEmpty(message = "owningTenantId must not be empty")
        private String owningTenantId;

    }
}
