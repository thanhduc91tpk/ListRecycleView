package com.uits.listrecycleview

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.uits.listrecycleview.interfaces.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mListData : MutableList<Singer>
    private lateinit var mMainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        mListData = mutableListOf("Nguyen Van A", "Nguyen Van B"
//                , "Nguyen Van C", "Nguyen Van D")
        mListData = mutableListOf()
        mListData.add(Singer("Cam Ly","Ly Chieu Chieu",R.raw.songgio))
        mListData.add(Singer("Dan Nguyen","Dap Mo Cuoc Tinh",R.raw.songgio))
        mListData.add(Singer("Errik","Em Sai Chung Ta Sai",R.raw.songgio))
        mListData.add(Singer("Jack","Song Gio",R.raw.songgio))

        mRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        mMainAdapter = MainAdapter(mListData, object : OnItemClickListener{
            override fun onItemClick(position: Int) {
                var mPlayer  = MediaPlayer.create(this@MainActivity, mListData[position].mSongUrl!!)
                mPlayer.start()
            }
        })

        mRecycleView.adapter = mMainAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}