package com.zpan.love;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 测试类
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        initView();
    }

    private void initView() {
        bubbleSort();


    }

    /**
     * 冒泡排序
     */
    private void bubbleSort() {
        int[] nums = {4, 34, 2, 36, 9, 67, 23};

        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int k = 0;k < nums.length;k ++) {
            Log.e("zpan", "k - " + k + "=" + nums[k]);
        }


    }
}
