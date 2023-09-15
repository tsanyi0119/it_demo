package com.example.it_demo.user;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.it_demo.R;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;

public class UserStatisticsMainActivity extends AppCompatActivity {

    private Button btn_mode_assets , btn_mode_expenses;
    private View view_assets , view_expenses;

    private PieChart pieChart;

    private ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_statistics_main);
        view_assets = findViewById(R.id.view_assets);
        view_expenses = findViewById(R.id.view_expenses);
        btn_mode_assets = findViewById(R.id.btn_mode_assets);
        btn_mode_expenses = findViewById(R.id.btn_mode_expenses);
        pieChart = findViewById(R.id.bar_piechart);
        setupUI();

    }

    private void setupUI() {

        btn_mode_assets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAssetsView();
            }
        });

        btn_mode_expenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setExpensesView();
            }
        });

        setExpensesView();

    }

    //設定資產UI配置
    private void setAssetsView() {
        view_assets.setVisibility(View.VISIBLE);
        view_expenses.setVisibility(View.GONE);
        btn_mode_assets.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAD689")));
        btn_mode_expenses.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFB")));
    }

    //設定支出UI配置
    private void setExpensesView() {
        view_assets.setVisibility(View.GONE);
        view_expenses.setVisibility(View.VISIBLE);
        btn_mode_assets.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FFFFFB")));
        btn_mode_expenses.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#FAD689")));
        setExpensesPieChart();
    }

    //設定支出圖
    private void setExpensesPieChart() {

        entries.clear();
        entries.add(new PieEntry(10f,"飲食"));
        entries.add(new PieEntry(20f,"交通"));
        entries.add(new PieEntry(30f,"醫療"));
        entries.add(new PieEntry(20f,"寵物"));
        entries.add(new PieEntry(10f,"生活"));
        entries.add(new PieEntry(10f,"數位"));

        pieChart.getDescription().setEnabled(false);//設置PieChart圖表的描述
        pieChart.setExtraOffsets(20, 0, 20, 0);//圓餅圖上下左右的間距

        pieChart.setDragDecelerationFrictionCoef(0.95f);//設置PieChart圖表轉動阻力摩擦係數
        pieChart.setDrawCenterText(true);//設置是否顯示内部圓文字
        pieChart.setCenterTextTypeface(Typeface.DEFAULT_BOLD);//設置pieChart中間文字粗體
        pieChart.setCenterTextSize(15f);//設置pieChart中間文字大小
        pieChart.setCenterTextColor(Color.GRAY);//設置pieChart中間文字顏色
        pieChart.setCenterText("支出比例");//設置PieChart内部圓文字的内容，只有環形圖看的出來

        pieChart.setEntryLabelColor(Color.BLACK);//設置pieChart圖表文字顏色
        pieChart.setEntryLabelTextSize(20f);//設置pieChart圖表文字大小
        pieChart.setEntryLabelTypeface(Typeface.DEFAULT_BOLD);//設置pieChart中間文字粗體

        pieChart.setDrawHoleEnabled(true);//true是環形圖 false是圓餅圖
        pieChart.setHoleColor(Color.WHITE);//設置中間空白顏色，只有環形圖看的出來

        pieChart.setTransparentCircleColor(Color.WHITE);//設置透明圓環的顏色，只有環形圖看的出來
        pieChart.setTransparentCircleAlpha(50);//設置PieChart透明圆環透明度

        pieChart.setHoleRadius(40f);//設置內部圓的大小，只有環形圖看的出來

        pieChart.setTransparentCircleRadius(50f);//設置PieChart内部透明圆環的半徑

        pieChart.setRotationAngle(0);//設置pieChart圖表起始角度

        pieChart.setRotationEnabled(true);//設置pieChart是否能夠手動旋轉
        pieChart.setHighlightPerTapEnabled(true);//設置piecahrt區塊點擊突出
        pieChart.animateY(1400, Easing.EaseInOutQuad);// 設置pieChart動態

        Legend l = pieChart.getLegend();
        l.setEnabled(false);//是否顯示圖例

        PieDataSet dataSet = new PieDataSet(entries, "");//設定數據

        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        dataSet.setValueLinePart2Length(0.3f);//設置第一部分線長度
        dataSet.setValueLinePart1Length(0.5f);//設置第二部分線長度

        dataSet.setSliceSpace(3f);//設置Item之間的縫隙
        dataSet.setIconsOffset(new MPPointF(0, 40));

        dataSet.setSelectionShift(15f);//設置Item被選中位置彈起距離

        ArrayList<Integer>colors= new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.JOYFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.COLORFUL_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.LIBERTY_COLORS) {
            colors.add(c);
        }
        for (int c : ColorTemplate.PASTEL_COLORS) {
            colors.add(c);
        }

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setDrawValues(false);            //設置是否顯示數據
        data.setValueTextColor(Color.BLACK);  //設置全部DataSet百分比文字顏色
        data.setValueTextSize(20f);          //設置全部DataSet百分比文字大小
        data.setValueFormatter(new PercentFormatter());

        pieChart.setData(data);//為圖表添加數據

        pieChart.highlightValues(null);//設置高亮顯示
        pieChart.setDrawEntryLabels(false);
        pieChart.invalidate();//將圖表刷新以顯示設定的屬性與數值

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            //點開事件
            @Override
            public void onValueSelected(Entry e, Highlight h) {

                PieEntry pieEntry = (PieEntry) e;
                Log.e("test",e.toString());

            }
            //關閉事件
            @Override
            public void onNothingSelected() {
                Log.e("test","關閉");
            }
        });
    }
}