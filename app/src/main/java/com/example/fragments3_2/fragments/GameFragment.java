package com.example.fragments3_2.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.fragments3_2.GameModel;
import com.example.fragments3_2.databinding.FragmentGameBinding;


public class GameFragment extends Fragment {

    private FragmentGameBinding binding;
    private GameModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        model = (GameModel) getArguments().getSerializable("game");
        setUI();
        initClicks();
    }

    private void initClicks() {
        binding.applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.answerEt.getText().toString().trim().equalsIgnoreCase(model.answer)) {
                    Toast.makeText(requireContext(), "Правильно", Toast.LENGTH_SHORT).show();
                } else {
                    binding.answerEt.setError("Вы ошиблись");
                }
            }
        });

        binding.hintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(requireContext())
                        .setMessage("Хорошо подумай")

                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    private void setUI() {
        Glide.with(requireContext()).load(model.firstImg).into(binding.firstImg);
        Glide.with(requireContext()).load(model.secondImg).into(binding.secondImg);
        Glide.with(requireContext()).load(model.thirdImg).into(binding.thirdImg);
        Glide.with(requireContext()).load(model.fourthImg).into(binding.fourthImg);
        binding.countTv.setText(model.levelDisplay);
    }
}