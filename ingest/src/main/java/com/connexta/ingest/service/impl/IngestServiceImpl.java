/*
 * Copyright (c) Connexta
 *
 * This is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3
 * of the License, or any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the
 * GNU Lesser General Public License is distributed along with this
 * program and can be found at http://www.gnu.org/licenses/lgpl.html.
 */
package com.connexta.ingest.service.impl;

import com.connexta.ingest.service.api.IngestRequest;
import com.connexta.ingest.service.api.IngestResponse;
import com.connexta.ingest.service.api.IngestService;
import org.springframework.stereotype.Service;

@Service
public class IngestServiceImpl implements IngestService {
  @Override
  public IngestResponse ingest(IngestRequest request) {
    return null;
  }
}