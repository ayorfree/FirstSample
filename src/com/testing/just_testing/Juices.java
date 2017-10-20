package com.testing.just_testing;

/**
 * builder_pattern_test
 *
 * @author ayorfree
 * @create 2017-10-17-下午3:36
 */

public class Juices {
    private final int apple;
    private final int orange;
    private final int peal;
    private final int cherry;
    private final int banana;

    public static class Builder {
        private int apple;
        private int orange;

        private int peal = 0;
        private int cherry = 0;
        private int banana = 0;

        public Builder(int apple, int orange) {
            this.apple = apple;
            this.orange = orange;
        }

        public Builder peal(int val) {
            peal = val;
            return this;
        }

        public Builder cherry(int val) {
            cherry = val;
            return this;
        }

        public Builder banana(int val) {
            banana = val;
            return this;
        }

        public Juices build() {
            return new Juices(this);
        }
    }

    private Juices(Builder builder) {
        apple = builder.apple;
        orange = builder.orange;
        peal = builder.peal;
        cherry = builder.cherry;
        banana = builder.banana;
    }

    public static void main(String[] args) {
        Juices juices = new Juices.Builder(100,100).cherry(110).banana(200).peal(20).build();
    }
}
