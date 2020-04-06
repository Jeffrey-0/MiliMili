package com.demo.bean;

import com.demo.domain.*;

import java.util.List;

public class PageInfo {
    private List<Resource> resourceList;
    private List<Admin> list;
    private List<User> userList;
    private List<Posting> postingList;
    private List<Post> postList;
//    private List<Product> productList;
    private List<Category> categoryList;
    // 当前页
    private Integer currentPage;
    // 开始页码
    private Integer beginPage;
    // 结束页码
    private Integer endPage;
    // 总页数
    private Integer totalPages;
    // 总记录数
    private Long totalRecord;
    //资源种类数量
    private Long totalCategory;
    //资源总记录数
    private Long totalResource;
    //帖子总记录数
    private Long totalPosting;
    //评论总记录数
    private Long totalPost;

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public PageInfo(List<Post> postList, Integer currentPage, Long totalPost,Post a) {
        super();
        this.postList = postList;
        this.currentPage = currentPage;
        this.totalPost = totalPost;
        if (totalPost % 10 == 0) {
            this.totalPages = totalPost.intValue() / 10;
        } else {
            this.totalPages = totalPost.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;

            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }
    }


    public List<Posting> getPostingList() {
        return postingList;
    }

    public void setPostingList(List<Posting> postingList) {
        this.postingList = postingList;
    }

    public PageInfo(List<Posting> postingList, Integer currentPage, Long totalPosting, boolean v) {
        super();
        this.postingList = postingList;
        this.currentPage = currentPage;
        this.totalPosting = totalPosting;
        if (totalPosting % 10 == 0) {
            this.totalPages = totalPosting.intValue() / 10;
        } else {
            this.totalPages = totalPosting.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;

            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }
    }


    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

    public PageInfo(List<Resource> resourceList, Integer currentPage, Long totalResource, char v) {
        super();
        this.resourceList = resourceList;
        this.currentPage = currentPage;
        this.totalResource = totalResource;
        if (totalResource % 10 == 0) {
            this.totalPages = totalResource.intValue() / 10;
        } else {
            this.totalPages = totalResource.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;

            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }

//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }

    public List<User> getUserList() {
        return userList;
    }

    public PageInfo(List<Category> categoryList, Integer currentPage, Long totalCategory ,double a) {
        super();
        this.categoryList = categoryList;
        this.currentPage = currentPage;
        this.totalCategory = totalCategory;

        // 总页数计算
        if (totalCategory % 10 == 0) {
            this.totalPages = totalCategory.intValue() / 10;
        } else {
            this.totalPages = totalCategory.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;

            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }

    }

//    public PageInfo(List<Product> productList, Integer currentPage, Long totalRecord, String a) {
//        super();
//        this.productList = productList;
//        this.currentPage = currentPage;
//        this.totalRecord = totalRecord;
//
//        // 总页数计算
//        if (totalRecord % 10 == 0) {
//            this.totalPages = totalRecord.intValue() / 10;
//        } else {
//            this.totalPages = totalRecord.intValue() / 10 + 1;
//        }
//        // 中间页码显示5页码
//        if (this.totalPages < 5) {
//            this.beginPage = 1;
//            this.endPage = totalPages;
//        } else {
//            this.beginPage = currentPage - 2;
//            this.endPage = currentPage + 2;
//
//            if (this.beginPage <= 0) {
//                this.beginPage = 1;
//                this.endPage = 5;
//            }
//            if (this.endPage > this.totalPages) {
//                this.beginPage = this.totalPages - 5;
//                this.endPage = this.totalPages;
//            }
//        }
//
//    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public PageInfo(List<User> userList, Integer currentPage, Long totalRecord, int a) {
        super();
        this.userList = userList;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        if (totalRecord % 10 == 0) {
            this.totalPages = totalRecord.intValue() / 10;
        } else {
            this.totalPages = totalRecord.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;
            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }

    }

    public PageInfo(List<Admin> list, Integer currentPage, Long totalRecord) {
        super();
        this.list = list;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;

        // 总页数计算
        if (totalRecord % 10 == 0) {
            this.totalPages = totalRecord.intValue() / 10;
        } else {
            this.totalPages = totalRecord.intValue() / 10 + 1;
        }
        // 中间页码显示5页码
        if (this.totalPages < 5) {
            this.beginPage = 1;
            this.endPage = totalPages;
        } else {
            this.beginPage = currentPage - 2;
            this.endPage = currentPage + 2;

            if (this.beginPage <= 0) {
                this.beginPage = 1;
                this.endPage = 5;
            }
            if (this.endPage > this.totalPages) {
                this.beginPage = this.totalPages - 5;
                this.endPage = this.totalPages;
            }
        }

    }

    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

}
