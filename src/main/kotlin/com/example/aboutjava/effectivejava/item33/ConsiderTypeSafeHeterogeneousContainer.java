package com.example.aboutjava.effectivejava.item33;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Item 33 - 타입 안정성을 위해서 이종 컨테이너를 고려해야합니다.<p>
 * <p>
 * 컬렉션 API로 대표되는 일반적인 제네릭 형태에는 한 컨테이너가 다룰 수 있는 타입 매개변수의 수가 고정되어 있다.<p>
 * 하지만 컨테이너 자체가 아닌 키를 타입 매개변수로 바꾸면 이런 제약이 없는 타입 안전 이종 컨테이너를 만들 수 있다.<p>
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
            favorites.put(Objects.requireNonNull(type), type.cast(instance));
        }

        @Override
        public <T> T getFavorite(Class<T> type) {
            return type.cast(favorites.get(type));
        }
    }

    public static void main(String[] args) {
        Favorites favorites = new FavoritesImpl();
        favorites.putFavorite(String.class, "Java");
        favorites.putFavorite(Integer.class, 0xcafebabe);
        favorites.putFavorite(Class.class, Favorites.class);

        String favoriteString = favorites.getFavorite(String.class);
        int favoriteInteger = favorites.getFavorite(Integer.class);
        Class<?> favoriteClass = favorites.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString, favoriteInteger, favoriteClass.getName());
    }
}
