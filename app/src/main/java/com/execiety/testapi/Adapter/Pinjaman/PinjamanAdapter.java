package com.execiety.testapi.Adapter.Pinjaman;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.execiety.testapi.Model.Pinjaman.DataPinjaman;
import com.execiety.testapi.Model.Pinjaman.Pinjaman;
import com.execiety.testapi.R;

import java.util.List;

public class PinjamanAdapter extends RecyclerView.Adapter<PinjamanAdapter.MyViewHolder> {
    List<DataPinjaman> mPinjamanList;

    public PinjamanAdapter(List <DataPinjaman> PinjamanList) {
        mPinjamanList = PinjamanList;
    }

    @Override
    public MyViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.pinjaman_list, parent, false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder (MyViewHolder holder,final int position){
        holder.mTextViewIdPinjaman.setText("Id Pinjaman : " + mPinjamanList.get(position).getIdpinjaman());
        holder.mTextViewNamaAnggota.setText("Nama Anggota : " + mPinjamanList.get(position).getNamaAnggota());
        holder.mTextViewNoAnggota.setText("No Anggota : " + mPinjamanList.get(position).getNoAnggota());
        holder.mTextViewNIKAnggota.setText("NIK Anggota : " + mPinjamanList.get(position).getNIKAnggota());
        holder.mTextViewNoPinjaman.setText("No Pinjaman : " + mPinjamanList.get(position).getNoPinjaman());
        holder.mTextViewJenisPinjaman.setText("Jenis Pinjaman : " + mPinjamanList.get(position).getJenisPinjaman());
        holder.mTextViewTotalTagihan.setText("Total Tagihan : " + mPinjamanList.get(position).getTotalTagihan());
        holder.mTextViewTotalTerbayar.setText("Total Terbayar : " + mPinjamanList.get(position).getTotalTerbayar());
        holder.mTextViewTotalSisa.setText("Total Sisa : " + mPinjamanList.get(position).getTotalSisa());
        holder.mTextViewJatuhTempo.setText("Jatuh Tempo : " + mPinjamanList.get(position).getJatuhTempo());
    }

    @Override
    public int getItemCount () {
        return mPinjamanList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdPinjaman, mTextViewNamaAnggota, mTextViewNoAnggota,
                mTextViewNIKAnggota, mTextViewNoPinjaman, mTextViewJenisPinjaman,
                mTextViewTotalTagihan, mTextViewTotalTerbayar, mTextViewTotalSisa, mTextViewJatuhTempo;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdPinjaman = (TextView) itemView.findViewById(R.id.tv_list_id_pinjaman);
            mTextViewNamaAnggota = (TextView) itemView.findViewById(R.id.tv_list_nama_anggota);
            mTextViewNoAnggota = (TextView) itemView.findViewById(R.id.tv_list_no_anggota);
            mTextViewNIKAnggota = (TextView) itemView.findViewById(R.id.tv_list_nik_anggota);
            mTextViewNoPinjaman = (TextView) itemView.findViewById(R.id.tv_list_no_pinjaman);
            mTextViewJenisPinjaman = (TextView) itemView.findViewById(R.id.tv_list_jenis_pinjaman);
            mTextViewTotalTagihan = (TextView) itemView.findViewById(R.id.tv_list_total_tagihan);
            mTextViewTotalTerbayar = (TextView) itemView.findViewById(R.id.tv_list_total_terbayar);
            mTextViewTotalSisa = (TextView) itemView.findViewById(R.id.tv_list_total_sisa);
            mTextViewJatuhTempo = (TextView) itemView.findViewById(R.id.tv_list_jatuh_tempo);
        }
    }
}
