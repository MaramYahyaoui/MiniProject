package com.maram.makeup.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomProd", types = { Makeup.class })
public interface MakeupProjection {
public String getNomMakeup();
}
