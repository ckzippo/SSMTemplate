package com.jsdx.base;

import org.springframework.ui.Model;

/**
 * Created by Max on 2016/10/18.
 */
public class BaseController {

    public void setListPageModel(Model model, PagingResult results){
        int total=results.getTotalSize();
        int size=results.getPageSize();
        int page=results.getCurrentPage();
        int lastPage=(total-1)/size+1;
        int prevPage=(page-1)<1?1:(page-1);
        int nextPage=(page+1)>lastPage?lastPage:(page+1);
        model.addAttribute("list",results.getResultList());
        model.addAttribute("page",results.getCurrentPage());
        model.addAttribute("lastPage",(total-1)/size+1);
        model.addAttribute("prevPage",prevPage);
        model.addAttribute("nextPage",nextPage);
    }
}
