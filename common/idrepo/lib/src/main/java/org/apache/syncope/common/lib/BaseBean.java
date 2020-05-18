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
package org.apache.syncope.common.lib;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.apache.syncope.common.lib.log.AuditEntry;
import org.apache.syncope.common.lib.to.AbstractStartEndBean;
import org.apache.syncope.common.lib.to.AccessTokenTO;
import org.apache.syncope.common.lib.to.AnyTO;
import org.apache.syncope.common.lib.to.RealmTO;

@XmlType
@XmlSeeAlso({ AbstractStartEndBean.class, AccessTokenTO.class, AuditEntry.class, AnyTO.class, RealmTO.class })
public abstract class BaseBean implements Serializable {

    private static final long serialVersionUID = 8243277089603485380L;

}
