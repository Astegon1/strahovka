package com.example.betaforall.insurance;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
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

public class OsagoActivity extends AppCompatActivity {

    // Шаги
    private TextView step1, step2, step3, backButton;
    private LinearLayout step1View, step2View, step3View;
    private Button nextButton;
    private int currentStep = 1; // Текущий шаг (1, 2, 3)

    // Элементы для RecyclerView
    private RecyclerView faqRecyclerView;
    private RecyclerView infoBlockRecyclerView;
    private RecyclerView stepRecyclerView;
    private RecyclerView infoRecyclerView;
    private RecyclerView osago5RecyclerView;

    // Адаптеры
    private ExpandableAdapter faqAdapter;
    private InfoImageBlockAdapter infoBlockAdapter;
    private StepBlockAdapter stepAdapter;
    private InfoBlockAdapter infoAdapter;
    private InfoBlockAdapter osago5Adapter;

    // Списки
    private List<ExpandableItem> faqList;
    private List<InfoImageBlockItem> infoBlockList, infoBlockList2;
    private List<StepBlockItem> stepList;
    private List<InfoBlockItem> infoList;
    private List<InfoBlockItem> osago5List;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osago);

        // === Шаги ===
        step1 = findViewById(R.id.step1);
        step2 = findViewById(R.id.step2);
        step3 = findViewById(R.id.step3);
        step1View = findViewById(R.id.step1View);
        step2View = findViewById(R.id.step2View);
        step3View = findViewById(R.id.step3View);
        nextButton = findViewById(R.id.nextButton);
        backButton = findViewById(R.id.backText);  // Добавляем кнопку назад

        // Переход к следующему шагу
        nextButton.setOnClickListener(v -> {
            if (currentStep < 3) {
                currentStep++;
                updateStep();
            }
        });

        // Переход к предыдущему шагу
        backButton.setOnClickListener(v -> {
            if (currentStep > 1) {
                currentStep--;
                updateStep();
            }
        });

        // Начальный шаг
        updateStep();

        // === FAQ блок ===
        faqRecyclerView = findViewById(R.id.vopros);
        String[] questions = getResources().getStringArray(R.array.faq_questions);
        String[] answers = getResources().getStringArray(R.array.faq_answers);
        faqList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            faqList.add(new ExpandableItem(questions[i], answers[i]));
        }
        faqAdapter = new ExpandableAdapter(faqList);
        faqRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        faqRecyclerView.setAdapter(faqAdapter);

        // === Инфоблок с иконками ===
        infoBlockRecyclerView = findViewById(R.id.OSAGO1);
        infoBlockRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoBlockList = new ArrayList<>();
        addInfoItem(infoBlockList, R.drawable.clockcirclefilled, "Быстрый расчёт", "Расчет цены за 2 минуты, выбор среди нескольких предложений");
        addInfoItem(infoBlockList, R.drawable.location, "В любом регионе", "Страховые выплаты за 1 день в Insurance world");
        addInfoItem(infoBlockList, R.drawable.chatrighttextfill, "Помощь 24/7", "Помощь по телефону и в чате — при ДТП и в других ситуациях");
        infoBlockAdapter = new InfoImageBlockAdapter(infoBlockList);
        infoBlockRecyclerView.setAdapter(infoBlockAdapter);

        // === Блок с шагами ===
        stepRecyclerView = findViewById(R.id.OSAGO2);
        stepRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stepList = new ArrayList<>();
        stepList.add(new StepBlockItem("Заполните данные авто и водителей в онлайн-калькуляторе"));
        stepList.add(new StepBlockItem("Рассчитайте стоимость ОСАГО сразу у нескольких партнеров"));
        stepList.add(new StepBlockItem("Оплатите картой и получите полис на e-mail"));
        stepAdapter = new StepBlockAdapter(stepList);
        stepRecyclerView.setAdapter(stepAdapter);

        // === Новый блок с InfoBlockAdapter ===
        infoRecyclerView = findViewById(R.id.OSAGO3);
        infoRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        infoList = Arrays.asList(
                new InfoBlockItem(
                        "Оформить полис за 2 минуты",
                        "E‑ОСАГО доступно онлайн — без очередей и пробок. Полис пришлем на e-mail. Он имеет такую же юридическую силу, как обычный на бланке",
                        ""
                ),
                new InfoBlockItem(
                        "Рассчитать со скидкой (КБМ) за безаварийность",
                        "При расчете ОСАГО на онлайн-калькуляторе учтем накопленную скидку за безаварийную езду",
                        ""
                ),
                new InfoBlockItem(
                        "Получить выплату за 1 день в Insurance world",
                        "Заявление подаете онлайн, оригиналы документов заберем сами. Как только предоставите полный пакет, выплата придет в течение одного дня",
                        ""
                )
        );

        infoAdapter = new InfoBlockAdapter(infoList, new InfoBlockAdapter.OnItemClickListener() {
            @Override
            public void onTitleClick(InfoBlockItem item) {}

            @Override
            public void onDescriptionClick(InfoBlockItem item) {}

            @Override
            public void onExtraClick(InfoBlockItem item) {}
        });

        infoBlockRecyclerView = findViewById(R.id.OSAGO4);
        infoBlockRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        infoBlockList2 = new ArrayList<>();
        addInfoItem(infoBlockList2,R.drawable.carcrash , "Возмещение по имуществу", "Полис покрывает ущерб автомобилю и другому имуществу потерпевших в ДТП по вашей вине. Возмещается до 400 000 ₽ на ремонт либо в форме денежной выплаты");
        addInfoItem(infoBlockList2, R.drawable.insurancehandsolid, "Возмещение по жизни и здоровью", "Полис покрывает ущерб жизни и здоровью потерпевших в ДТП по вашей вине: водителей, пассажиров, пешеходов. Возмещается до 500 000 ₽");
        infoBlockAdapter = new InfoImageBlockAdapter(infoBlockList2);
        infoBlockRecyclerView.setAdapter(infoBlockAdapter);

        infoRecyclerView.setAdapter(infoAdapter);

        // === Новый блок с InfoBlockAdapter (OSAGO5) ===
        osago5RecyclerView = findViewById(R.id.OSAGO5);
        osago5RecyclerView.setLayoutManager(new LinearLayoutManager(this));

        osago5List = Arrays.asList(
                new InfoBlockItem(
                        "Водите авто без аварий",
                        "Если у водителя не было аварий по его вине, он получает скидку (КБМ) за безаварийную езду и полис обходится дешевле",
                        ""
                ),
                new InfoBlockItem(
                        "Вписывайте в полис нужных водителей",
                        "Страховка обычно дешевле с ограниченным перечнем водителей. Чем больше стаж вождения и возраст водителя, тем ниже цена",
                        ""
                )
        );

        osago5Adapter = new InfoBlockAdapter(osago5List, new InfoBlockAdapter.OnItemClickListener() {
            @Override
            public void onTitleClick(InfoBlockItem item) {}

            @Override
            public void onDescriptionClick(InfoBlockItem item) {}

            @Override
            public void onExtraClick(InfoBlockItem item) {}
        });

        osago5RecyclerView.setAdapter(osago5Adapter);
    }

    // Обновление UI шагов
    private void updateStep() {
        // Обновляем внешний вид шагов
        updateStepUI();

        // Показать/скрыть соответствующие формы для каждого шага
        step1View.setVisibility(currentStep == 1 ? View.VISIBLE : View.GONE);
        step2View.setVisibility(currentStep == 2 ? View.VISIBLE : View.GONE);
        step3View.setVisibility(currentStep == 3 ? View.VISIBLE : View.GONE);

        // Активировать/деактивировать кнопку "Назад" в зависимости от текущего шага
        backButton.setVisibility(currentStep > 1 ? View.VISIBLE : View.GONE);
    }

    private void updateStepUI() {
        // Сбрасываем все шаги
        resetStepUI();

        // Обновляем шаг в зависимости от текущего
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
        }
    }

    private void resetStepUI() {
        // Сбрасываем все шаги в исходное состояние
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

    // Метод для добавления элементов в список
    private void addInfoItem(List<InfoImageBlockItem> list, int iconResId, String title, String description) {
        list.add(new InfoImageBlockItem(iconResId, title, description));
    }
}
