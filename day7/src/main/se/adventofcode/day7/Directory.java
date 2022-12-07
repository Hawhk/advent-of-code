package se.adventofcode.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Directory {
	@Override
	public String toString() {
		return "Directory [dirs=" + dirs.size() + ", files=" + files + ", size=" + size + ", parent="
				+ Optional.ofNullable(parent).map(Directory::getName).orElse(null) + ", name=" + name + "]";
	}

	private final List<Directory> dirs = new ArrayList<>();
	private final List<Integer> files = new ArrayList<>();

	private int size = 0;

	private Directory parent = null;
	private String name;

	public Directory(Directory parent, String name) {
		this.parent = parent;
		this.name = name;
	}

	public List<Directory> flaten() {
		List<Directory> flat = new ArrayList<>();

		dirs.stream().forEach(dir -> flat.addAll(dir.flaten()));
		flat.add(this);
		return flat;
	}

	public List<Directory> getDirs() {
		return dirs;
	}

	public int getSize() {
		if (size == 0) {
			int localSize = files.stream().reduce(0, Integer::sum)
					+ dirs.stream().map(Directory::getSize).reduce(0, Integer::sum);
			size = localSize;
		}
		return size;
	}

	public String getName() {
		return name;
	}

	public Directory getParent() {
		return parent;
	}

	public void addDir(Directory dir) {
		dirs.add(dir);
	}

	public void addFiles(int size) {
		files.add(size);
	}
}