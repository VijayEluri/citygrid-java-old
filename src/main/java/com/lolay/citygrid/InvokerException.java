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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvokerException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private List<ErrorCode> errorCodes = null;
	public InvokerException(ErrorResults errors) {
		super("Errors occurred while invoking a request");
		List<ErrorCode> errorCodes = new ArrayList<ErrorCode>(errors.getErrors().size());
		for (Error error : errors.getErrors()) {
			errorCodes.add(error.getErrorCode());
		}
		this.errorCodes = Collections.unmodifiableList(errorCodes);
	}
	
	public List<ErrorCode> getErrorCodes() {
		return errorCodes;
	}

	public boolean contains(ErrorCode errorCode) {
		return getErrorCodes().contains(errorCode);
	}
}