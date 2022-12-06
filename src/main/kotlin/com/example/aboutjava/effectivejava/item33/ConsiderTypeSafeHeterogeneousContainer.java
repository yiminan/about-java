package com.example.aboutjava.effectivejava.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Item 33 - 타입 안정성을 위해서 이종 컨테이너를 고려해야합니다.<p>
 */
class ConsiderTypeSafeHeterogeneousContainer {

    /**
     * Type safe heterogeneous container pattern - API
     */
    interface Favorites {

        public <T> void putFavorite(Class<T> type, T instance);

        public <T> T getFavorite(Class<T> type);
    }

    /**
     * Type safe heterogeneous container pattern - implementation
     */
    private static class FavoritesImpl implements Favorites {

        private Map<Class<?>, Object> favorites = new HashMap<>();

        @Override
        public <T> void putFavorite(Class<T> type, T instance) {
            favorites.put(Objects.requireNonNull(type), instance);
        }

        @Override
        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }

}
