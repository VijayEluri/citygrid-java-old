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
package com.lolay.citygrid.ads.tracking;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


/**
 * @see http://docs.citygridmedia.com/display/citygridv2/Places+that+Pay
 * @see TrackingInvoker
 */
@Path("/ads/tracker")
@Consumes(MediaType.TEXT_PLAIN)
@Produces("image/gif")
public interface TrackingClient {
	public static final String ACTION_TARGET = "action_target";
	public static final String LISTING_ID = "listing_id";
	public static final String REFERENCE_ID = "reference_id";
	public static final String PUBLISHER = "publisher";
	public static final String PLACEMENT = "placement";
	public static final String MOBILE_TYPE = "mobile_type";
	public static final String MUID = "muid";
	public static final String UA = "ua";
	public static final String IMPRESSION_ID = "i";
	public static final String SOURCE_PHONE = "sourcePhone";
	public static final String DIAL_PHONE = "dialPhone";
	
	@GET
	@Path("/imp")
	public void impression(
			@QueryParam(ACTION_TARGET) TrackingActionTarget actionTarget,
			@QueryParam(LISTING_ID) Integer listingId,
			@QueryParam(REFERENCE_ID) Integer referenceId,
			@QueryParam(PUBLISHER) String publisher,
			@QueryParam(IMPRESSION_ID) String impressionId,
			@QueryParam(PLACEMENT) String placement,
			@QueryParam(MOBILE_TYPE) String mobileType,
			@QueryParam(MUID) String muid,
			@QueryParam(SOURCE_PHONE) String sourcePhone,
			@QueryParam(DIAL_PHONE) String dialPhone,
			@QueryParam(UA) String ua);
}