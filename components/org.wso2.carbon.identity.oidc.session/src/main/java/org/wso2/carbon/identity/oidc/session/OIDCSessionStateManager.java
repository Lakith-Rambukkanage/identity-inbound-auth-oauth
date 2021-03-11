/*
 * Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.oidc.session;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Manages the OIDC session state.
 */
public interface OIDCSessionStateManager {

    /**
     * Generates a session state using the provided client id, client callback url and browser state cookie id.
     *
     * @param clientId
     * @param rpCallBackUrl
     * @param opBrowserState
     * @return generated session state value
     */
    String getSessionStateParam(String clientId, String rpCallBackUrl, String opBrowserState);

    /**
     * Adds the browser state cookie to the response.
     *
     * @param response
     * @return Cookie
     */
    @Deprecated
    Cookie addOPBrowserStateCookie(HttpServletResponse response);

    /**
     * Adds the browser state cookie with tenant qualified path to the response.
     *
     * @param response
     * @return Cookie
     */
    default Cookie addOPBrowserStateCookie(HttpServletResponse response, String tenantDomain) {

        return addOPBrowserStateCookie(response);
    }

}
