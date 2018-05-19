package com.walmartlabs.concord.server.api.process;

/*-
 * *****
 * Concord
 * -----
 * Copyright (C) 2017 Wal-Mart Store, Inc.
 * -----
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =====
 */

import io.swagger.annotations.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.Map;

@Api(value = "ProcessQueue", authorizations = {@Authorization("api_key")})
@Path("/api/v1/process/queue")
public interface ProcessQueueResource {

    @POST
    @ApiOperation(value = "Take a payload from the queue", response = File.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK",
                    response = File.class,
                    responseHeaders = @ResponseHeader(name = "X-Concord-InstanceId", description = "Process instance ID", response = String.class))})
    @Path("/take")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    Response take(@ApiParam Map<String, Object> agentCapabilities,
                  @Context HttpHeaders headers);
}