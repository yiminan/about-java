package com.example.aboutjava.effectivejava.item33;

/**
 * Item 33 - 타입 안정성을 위해서 이종 컨테이너를 고려해야합니다.<p>
 */
class ConsiderTypeSafeHeterogeneousContainer {

    /**
     * Type safe heterogeneous container pattern - API
     */
    interface Favorites {

        public <T> void putFavorite(Class<T> type, T instance);

        public <T> void getFavorite(Class<T> type);
    }
}
