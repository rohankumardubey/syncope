/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.core.provisioning.java.data;

import org.apache.syncope.common.lib.to.AuthProfileTO;
import org.apache.syncope.core.persistence.api.entity.EntityFactory;
import org.apache.syncope.core.persistence.api.entity.auth.AuthProfile;
import org.apache.syncope.core.provisioning.api.data.AuthProfileDataBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthProfileDataBinderImpl implements AuthProfileDataBinder {

    @Autowired
    private EntityFactory entityFactory;

    @Override
    public AuthProfileTO getAuthProfileTO(final AuthProfile authProfile) {
        AuthProfileTO authProfileTO = new AuthProfileTO();
        authProfileTO.setKey(authProfile.getKey());
        authProfileTO.setOwner(authProfile.getOwner());
        authProfileTO.getGoogleMfaAuthTokens().addAll(authProfile.getGoogleMfaAuthTokens());
        authProfileTO.getGoogleMfaAuthAccounts().addAll(authProfile.getGoogleMfaAuthAccounts());
        authProfileTO.getU2FRegisteredDevices().addAll(authProfile.getU2FRegisteredDevices());
        authProfileTO.setWebAuthnAccount(authProfile.getWebAuthnAccount());
        return authProfileTO;
    }

    @Override
    public AuthProfile create(final AuthProfileTO authProfileTO) {
        AuthProfile authProfile = entityFactory.newEntity(AuthProfile.class);
        authProfile.setOwner(authProfileTO.getOwner());
        authProfile.setGoogleMfaAuthTokens(authProfileTO.getGoogleMfaAuthTokens());
        authProfile.setGoogleMfaAuthAccounts(authProfileTO.getGoogleMfaAuthAccounts());
        authProfile.setU2FRegisteredDevices(authProfileTO.getU2FRegisteredDevices());
        authProfile.setWebAuthnAccount(authProfileTO.getWebAuthnAccount());
        return authProfile;
    }
}