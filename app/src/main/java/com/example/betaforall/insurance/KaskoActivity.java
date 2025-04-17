package com.example.betaforall.insurance;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.betaforall.R;
import com.example.betaforall.adapter.ExpandableAdapter;
import com.example.betaforall.adapter.InfoBlockAdapter;
import com.example.betaforall.adapter.InfoImageBlockAdapter;
import com.example.betaforall.adapter.StepBlockAdapter;
import com.example.betaforall.model.ExpandableItem;
import com.example.betaforall.model.InfoBlockItem;
import com.example.betaforall.model.InfoImageBlockItem;
import com.example.betaforall.model.StepBlockItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KaskoActivity extends AppCompatActivity {

    private TextView step1, step2, step3, backButton;
    private LinearLayout step1View, step2View, step3View;
    private TextView step4, step5;
    private LinearLayout step4View, step5View;

    private Button nextButton;
    private int currentStep = 1;

    private RecyclerView faqRecyclerView;
    private RecyclerView infoBlockRecyclerView;
    private RecyclerView stepRecyclerView;
    private RecyclerView infoRecyclerView;
    private RecyclerView kasko5RecyclerView;

    private ExpandableAdapter faqAdapter;
    private InfoImageBlockAdapter infoBlockAdapter;
    private StepBlockAdapter stepAdapter;
    private InfoBlockAdapter infoAdapter;
    private InfoBlockAdapter kasko5Adapter;

    private List<ExpandableItem> faqList;
    private List<InfoImageBlockItem> infoBlockList;
    private List<StepBlockItem> stepList;
    private List<InfoBlockItem> infoList;
    private List<InfoBlockItem> kasko5List;
    private RecyclerView kasko4RecyclerView;
    private InfoImageBlockAdapter kasko4Adapter;
    private List<InfoImageBlockItem> kasko4List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kasko);

        // Шаги
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step4 = findViewById(R.id.step4);
        step5 = findViewById(R.id.step5);
        step4View = findViewById(R.id.step4View);
        step5View = findViewById(R.id.step5View);
        step1View = findViewById(R.id.step1View);
        step2View = findViewById(R.id.step2View);
        step3View = findViewById(R.id.step3View);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backText);

        nextButton.setOnClickListener(v -> {
            if (currentStep < 5) {
                currentStep++;
                updateStep();
            }
        });

        backButton.setOnClickListener(v -> {
            if (currentStep > 1) {
                currentStep--;
                updateStep();
            }
        });


        updateStep();

        // FAQ блок
        faqRecyclerView = findViewById(R.id.vopros);
        String[] questions = getResources().getStringArray(R.array.faq_kasko_questions);
        String[] answers = getResources().getStringArray(R.array.faq_kasko_answers);
        faqList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            faqList.add(new ExpandableItem(questions[i], answers[i]));
        }
        faqAdapter = new ExpandableAdapter(faqList);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        faqRecyclerView.setAdapter(faqAdapter);

        // Инфоблок с иконками
        infoBlockRecyclerView = findViewById(R.id.KASKO1);
        infoBlockRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoBlockList = new ArrayList<>();
        addInfoItem(infoBlockList, R.drawable.carrepair11, "Отремонтируем без справок", "Если повредили фару, зеркало или лобовое стекло, справки не нужны. Сразу направим на ремонт");
        addInfoItem(infoBlockList,R.drawable.clockcirclefilled , "Направим на ремонт за час", "Загрузите документы в приложении. Ущерб оценим по фото и выдадим направление на ремонт за час");
        infoBlockAdapter = new InfoImageBlockAdapter(infoBlockList);
        infoBlockRecyclerView.setAdapter(infoBlockAdapter);

        // Шаги
        stepRecyclerView = findViewById(R.id.KASKO2);
        stepRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stepList = new ArrayList<>();
        stepList.add(new StepBlockItem("Заполните данные автомобиля"));
        stepList.add(new StepBlockItem("Выберите защиту и узнайте цену"));
        stepList.add(new StepBlockItem("Оплатите картой онлайн"));
        stepList.add(new StepBlockItem("Получите полис по эл. почте"));
        stepAdapter = new StepBlockAdapter(stepList);
        stepRecyclerView.setAdapter(stepAdapter);

        // Информационный блок
        infoRecyclerView = findViewById(R.id.KASKO3);
        infoRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoList = Arrays.asList(
                new InfoBlockItem("Включите франшизу с первого случая",
                        "Начиная с первого страхового случая часть расходов на ремонт автомобиля оплачиваете вы, остальное покрывает страховая. Такой полис дешевле до 70%", "Подробнее"),
                new InfoBlockItem("Включите франшизу со второго случая",
                        "По первому случаю ремонт покроет страховая. Начиная со второго случая часть расходов оплачиваете вы, остальное — страховая. Такой полис дешевле до 55%", "Подробнее"),
                new InfoBlockItem("Быстрые выплаты",
                        "Если ездите редко, оформите полис на 7000 или 12 000 км. Если не уложитесь, можно продлить. Такой полис дешевле до 35%", "Подробнее")
        );
        infoAdapter = new InfoBlockAdapter(infoList, new InfoBlockAdapter.OnItemClickListener() {
            @Override
            public void onTitleClick(InfoBlockItem item) {}

            @Override
            public void onDescriptionClick(InfoBlockItem item) {}

            @Override
            public void onExtraClick(InfoBlockItem item) {}
        });
        infoRecyclerView.setAdapter(infoAdapter);

        // KASKO4
        kasko4RecyclerView = findViewById(R.id.KASKO4);
        kasko4RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        kasko4List = new ArrayList<>();
        addInfoItem(kasko4List,R.drawable.carrepair11 , "", "Лучше всего подходят для выполнения требуемых ремонтных работ");
        addInfoItem(kasko4List,R.drawable._0469887_document_policy_safety_confidential_insurance_icon , "", "Отвечают требованиям гарантии, если у авто не закончился гарантийный период");
        addInfoItem(kasko4List,R.drawable.star11, "", "Оцениваются нашими клиентами на 4 и выше по пятибалльной шкале");
        addInfoItem(kasko4List,R.drawable.location , "", "Имеют удобное расположение и время работы");
        kasko4Adapter = new InfoImageBlockAdapter(kasko4List);
        kasko4RecyclerView.setAdapter(kasko4Adapter);


        // Заключительный блок
        kasko5RecyclerView = findViewById(R.id.KASKO5);
        kasko5RecyclerView.setLayoutManager(new LinearLayoutManager(this));
        kasko5List = Arrays.asList(
                new InfoBlockItem("Поддержим на месте ДТП", "Звоните 8 800 555-15-99 — экстренно проконсультируем по телефону", ""),
                new InfoBlockItem("Поможем справиться со стрессом", "Поддержим и расскажем, что делать", ""),
                new InfoBlockItem("Подскажем по документам", "Разберемся, нужно ли вызывать ГИБДД или подойдет европротокол. Подскажем, как сделать фото и заявить случай в приложении", ""),
                new InfoBlockItem("Оплатим эвакуатор", "Если после аварии автомобиль не может двигаться своим ходом, возместим расходы на эвакуатор на сумму до 10 000 ₽", "")
        );
        kasko5Adapter = new InfoBlockAdapter(kasko5List, new InfoBlockAdapter.OnItemClickListener() {
            @Override
            public void onTitleClick(InfoBlockItem item) {}

            @Override
            public void onDescriptionClick(InfoBlockItem item) {}

            @Override
            public void onExtraClick(InfoBlockItem item) {}
        });
        kasko5RecyclerView.setAdapter(kasko5Adapter);
    }

    private void updateStep() {
        updateStepUI();
        step1View.setVisibility(currentStep == 1 ? View.VISIBLE : View.GONE);
        step2View.setVisibility(currentStep == 2 ? View.VISIBLE : View.GONE);
        step3View.setVisibility(currentStep == 3 ? View.VISIBLE : View.GONE);
        step4View.setVisibility(currentStep == 4 ? View.VISIBLE : View.GONE);
        step5View.setVisibility(currentStep == 5 ? View.VISIBLE : View.GONE);
        backButton.setVisibility(currentStep > 1 ? View.VISIBLE : View.GONE);
    }


    private void updateStepUI() {
        resetStepUI();
        switch (currentStep) {
            case 1:
                step1.setTextColor(Color.BLACK);
                step1.setTypeface(null, Typeface.BOLD);
                step1.setBackgroundResource(R.drawable.circle_filled);
                break;
            case 2:
                step2.setTextColor(Color.BLACK);
                step2.setTypeface(null, Typeface.BOLD);
                step2.setBackgroundResource(R.drawable.circle_filled);
                break;
            case 3:
                step3.setTextColor(Color.BLACK);
                step3.setTypeface(null, Typeface.BOLD);
                step3.setBackgroundResource(R.drawable.circle_filled);
                break;
            case 4:
                step4.setTextColor(Color.BLACK);
                step4.setTypeface(null, Typeface.BOLD);
                step4.setBackgroundResource(R.drawable.circle_filled);
                break;
            case 5:
                step5.setTextColor(Color.BLACK);
                step5.setTypeface(null, Typeface.BOLD);
                step5.setBackgroundResource(R.drawable.circle_filled);
                break;
        }
    }


    private void resetStepUI() {
        step1.setTextColor(getResources().getColor(R.color.step_default));
        step1.setTypeface(null, Typeface.NORMAL);
        step1.setBackgroundResource(R.drawable.circle_border);

        step2.setTextColor(getResources().getColor(R.color.step_default));
        step2.setTypeface(null, Typeface.NORMAL);
        step2.setBackgroundResource(R.drawable.circle_border);

        step3.setTextColor(getResources().getColor(R.color.step_default));
        step3.setTypeface(null, Typeface.NORMAL);
        step3.setBackgroundResource(R.drawable.circle_border);
    }

    private void addInfoItem(List<InfoImageBlockItem> list, int iconResId, String title, String description) {
        list.add(new InfoImageBlockItem(iconResId, title, description));
    }
}
