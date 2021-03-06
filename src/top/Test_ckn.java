package top;

import HModel.Column_ian;
import SA.Unify_new_fast;
import common.Constant;
import queries.QueryPicture;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test_ckn {
    public static void main(String[] args) {
        // 数据分布参数
        BigDecimal totalRowNumber = new BigDecimal("100000000");

        List<Column_ian> CKdist = new ArrayList<Column_ian>();
//        double step0 = 1;
//        List<Double> x0 = new ArrayList<Double>();
//        for (int i = 1; i <= 1281; i++) {
//            x0.add((double) i);
//        }
//        List<Integer> y0 = new ArrayList<Integer>();
//        for (int i = 1; i <= 1280; i++) {
//            y0.add(1);
//        }
//        Column_ian ck0 = new Column_ian(step0, x0, y0);
//        CKdist.add(ck0);
//
//        double step1 = 1;
//        List<Double> x1 = new ArrayList<Double>();
//        for (int i = 1; i <= 6; i++) {
//            x1.add((double) i);
//        }
//        List<Double> y1 = new ArrayList<Double>();
//        for (int i = 1; i <= 5; i++) {
//            y1.add(1);
//        }
//        for (int i = 1; i < 8; i++) {
//            Column_ian ck1 = new Column_ian(step1, x1, y1);
//            CKdist.add(ck1);
//        }

        double step1 = 1;
        List<Double> x1 = new ArrayList<Double>();
        for (int i = 1; i <= 11; i++) {
            x1.add((double) i);
        }
        List<Double> y1 = new ArrayList<Double>();
        for (int i = 1; i <= 10; i++) {
            y1.add(1.0);
        }
        for (int i = 0; i < 8; i++) {
            Column_ian ck1 = new Column_ian(step1, x1, y1);
            CKdist.add(ck1);
        }

        int ckn = CKdist.size();

        // 查询参数
        double[][] starts = new double[ckn][];
        double[][] lengths = new double[ckn][];
//        int[] qpernum = new int[]{10,10,10,10,10,10,10,10};
        int[] qpernum = new int[ckn];
        for(int i=0;i<ckn;i++) {
            qpernum[i] = 1;
        }


//        int[]qpernum=newint[]{38,6,6,6,6,6,6,6};
//        int[] qpernum = new int[]{37, 37, 1, 1, 1, 1, 1, 1};
//        int[] qpernum = new int[]{73,1,1,1,1,1,1,1};

        //谨慎修改列内分布参数
        for (int i = 0; i < ckn; i++) {
//            starts[i] = new double[]{0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1, 0.1};
//            lengths[i] = new double[]{0.08, 0.2, 0.28, 0.16, 0.12, 0.04, 0.04, 0.04, 0.04, 0};
            starts[i] = new double[]{0,0,0,0,0,0,0,0,0,0};
            lengths[i] = new double[]{0,0,0,0,0,0,0,0,0,1};
        }
        QueryPicture queryPicture = new QueryPicture(starts, lengths, qpernum, 100);//2*250=500个查询

        //控制变量
        int X = 2;

        Unify_new_fast unify = new Unify_new_fast(totalRowNumber,
                ckn, CKdist,
                Constant.rowSize, Constant.fetchRowCnt, Constant.costModel_k, Constant.costModel_b, Constant.cost_session_around, Constant.cost_request_around,
                queryPicture,
                X);
        unify.isDiffReplicated = false;
        unify.combine();

    }

}
