package test;

public enum Color implements info {
    /*
     * 红色
     * */
    Red {
        @Override
        public String getColor() {
            return "红色";
        }
    },
    /*
     * 绿色
     * */
    GREEN {
        @Override
        public String getColor() {
            return "绿色";
        }
    },
    /*
    * 蓝色
    * */
    BLUE {
        @Override
        public String getColor() {
            return "蓝色";
        }
    };

}

