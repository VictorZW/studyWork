package com.cdsoft.mcm.index.mapper;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface QueryIndexMapper {
    List<HashMap> queryChSzIndex(HashMap params);
}
