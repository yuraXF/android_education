package com.example.yura.okhttpexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryEntityList {
    public static List<RepositoryEntity> repositoryEntities=new ArrayList<RepositoryEntity>();

    private RepositoryEntityList(){};

    public static void initsializeList(ArrayList<RepositoryEntity> repositoryEntities){
        if(RepositoryEntityList.repositoryEntities!=null) {
            RepositoryEntityList.repositoryEntities.clear();
        }
        for(RepositoryEntity repositoryEntity:repositoryEntities){
            RepositoryEntityList.repositoryEntities.add(repositoryEntity);
        }
        //RepositoryEntityList.repositoryEntities=new ArrayList<RepositoryEntity>(repositoryEntities);
    }
}
