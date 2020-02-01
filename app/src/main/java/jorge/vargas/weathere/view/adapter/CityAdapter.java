package jorge.vargas.weathere.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import jorge.vargas.weathere.BR;
import jorge.vargas.weathere.model.City;
import jorge.vargas.weathere.viewModel.MainActivityViewModel;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ItemCityViewHolder>{
    private int layoutId;
    private MainActivityViewModel viewModel;
    private List<City> cityList;

    public CityAdapter(@LayoutRes int layoutId, MainActivityViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @NonNull
    @Override
    public ItemCityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new ItemCityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemCityViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemCount() {
        return cityList == null ? 0 : cityList.size();
    }

    @Override
    public int getItemViewType(int position){
        return getLayoutIdForPosition(position);
    }

    public void setCityList(List<City> cityList){
        this.cityList = cityList;
    }


    class ItemCityViewHolder extends RecyclerView.ViewHolder{
        final ViewDataBinding binding;

        ItemCityViewHolder(ViewDataBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(MainActivityViewModel viewModel, int position){
            binding.setVariable(BR.viewModel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }
    }
}
