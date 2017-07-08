package br.com.reneluan.news.di;

interface HasComponent<C> {
    fun getComponent() : C
}
