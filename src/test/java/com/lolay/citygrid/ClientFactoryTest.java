/*
 * Licensed to Lolay, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Lolay, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://github.com/lolay/citygrid/raw/master/LICENSE
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package com.lolay.citygrid;

import com.lolay.citygrid.content.places.search.SearchClient;

import junit.framework.TestCase;

public class ClientFactoryTest extends TestCase {
	public void testSearch() throws Exception {
		ClientFactory factory = new ClientFactory("http://api.citygridmedia.com");
		SearchClient search1 = factory.getSearch();
		assertNotNull(search1);
		SearchClient search2 = factory.getSearch();
		assertNotNull(search2);
		assertSame(search1, search2);
	}
}