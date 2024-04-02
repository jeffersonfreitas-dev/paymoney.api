package dev.jeffersonfreitas.paymoney.dto;

import java.util.Objects;

public record UserResponse(String uuid, String name) implements Comparable<UserResponse> {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserResponse that)) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(UserResponse o) {
        return this.name.compareTo(o.name);
    }
}
